import lombok.Getter;

public enum CacheReplacementPolicy {
    LRU("Least Recently Used"),
    MRU("Most Recently Used"),
    LFU("Least Frequently Used");

    @Getter
    private final String description;

    CacheReplacementPolicy(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}