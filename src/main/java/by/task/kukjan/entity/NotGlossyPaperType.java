package by.task.kukjan.entity;

public enum NotGlossyPaperType {
    NEWSPAPER("newspaper"),
    MAGAZINE("magazine");

    private String value;

    NotGlossyPaperType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}