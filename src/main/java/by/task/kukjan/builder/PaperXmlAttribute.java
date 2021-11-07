package by.task.kukjan.builder;

public enum PaperXmlAttribute {
    ID("id"),
    NOTE("note");
    private String value;

    PaperXmlAttribute(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
