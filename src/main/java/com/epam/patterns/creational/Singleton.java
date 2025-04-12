package com.epam.patterns.creational;

/**
 * Examples include:
 * <p>
 * Configuration Management: A global configuration object (e.g., managing application settings).
 * Logging: Centralized logging service accessed throughout the application.
 * Caching: A unified caching mechanism for resource reuse.
 * Database Connections: One instance managing access to the database.
 * Thread Pools: Managing a single shared thread pool for an application.
 */
public class Singleton {
    // Static instance of the class
    private static Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {
    }

    // Public static method to provide global access to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();  // Lazy initialization
        }
        return instance;
    }

    public static class Main {
        public static void main(String[] args) {
            Singleton s1 = Singleton.getInstance();
            Singleton s2 = Singleton.getInstance();
            System.out.println(s1 == s2);
        }
    }
}