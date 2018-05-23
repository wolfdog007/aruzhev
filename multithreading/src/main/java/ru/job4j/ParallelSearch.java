package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Search text in the files.
 *
 * @author Ruzhev Alexander
 * @since 23.05.2018
 */
@ThreadSafe
public class ParallelSearch {
    /**
     * The starting directory for the search.
     */
    private final String root;
    /**
     * Text for search.
     */
    private final String text;
    /**
     * Extension list.
     */
    private final List<String> exts;
    /**
     * Flag of finish.
     */
    private volatile boolean isFinish = false;
    /**
     * The queue files for search text.
     */
    @GuardedBy("itself")
    private final Queue<String> files = new LinkedList<>();
    /**
     * The list searching files.
     */
    @GuardedBy("itself")
    private final List<String> paths = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param root - the starting directory for the search
     * @param text - text for search
     * @param exts - extension list
     */
    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    /**
     * Created and started for search and read.
     */
    public void init() {
        Thread search = new Thread(() -> {
            System.out.println("search is start...");
            try {
                Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFileFailed(Path path, IOException exc) throws IOException {
                        return FileVisitResult.SKIP_SUBTREE;
                    }

                    @Override
                    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                        String current = path.toAbsolutePath().toString();
                        for (String extension : exts) {
                            if (current.endsWith(extension)) {
                                synchronized (files) {
                                    files.add(current);
                                }
                            }
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            isFinish = true;
            System.out.println("search is finish.");
        });

        Thread read = new Thread(() -> {
            System.out.println("read is start...");
            while (!isFinish) {
                synchronized (files) {
                    while (!files.isEmpty()) {
                        try {
                            Path current = Paths.get(files.poll());
                            if (Files.isReadable(current)) {
                                String content = new String(Files.readAllBytes(current));
                                if (content.contains(text)) {
                                    synchronized (paths) {
                                        paths.add(current.toAbsolutePath().toString());
                                    }
                                }
                            } else {
                                System.out.printf("%s - access denied!%s", current, System.lineSeparator());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            System.out.println("read is finish.");
        });
        search.start();
        read.start();
        try {
            read.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return result list.
     *
     * @return list of searching files
     */
    List<String> result() {
        synchronized (this.paths) {
            return this.paths;
        }
    }
}
