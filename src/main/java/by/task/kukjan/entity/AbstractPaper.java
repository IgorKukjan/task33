package by.task.kukjan.entity;

import java.time.MonthDay;


public class AbstractPaper {
    public static final String DEFAULT_NOTE = "-";

    private String id;
    private String note;
    private String title;
    private int numberOfPages;
    private int price;
    private boolean monthly;
    private boolean color;
    private MonthDay publicationDate;

    public AbstractPaper(){
        publicationDate = MonthDay.now();
    }

    public AbstractPaper(String id, String note, String title, int numberOfPages, int price,
                         boolean monthly, boolean color, MonthDay publicationDate) {
        this.id = id;
        this.note = note;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.monthly = monthly;
        this.color = color;
        this.publicationDate = publicationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isMonthly() {
        return monthly;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public MonthDay getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(MonthDay publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPaper paper = (AbstractPaper) o;
        return numberOfPages == paper.numberOfPages &&
                price == paper.price &&
                monthly == paper.monthly &&
                color == paper.color &&
                id.equals(paper.id) &&
                note.equals(paper.note) &&
                title.equals(paper.title) &&
                publicationDate.equals(paper.publicationDate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + numberOfPages;
        result = 31 * result + price;
        result = 31 * result + (monthly ? 1 : 0);
        result = 31 * result + (color ? 1 : 0);
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AbstractPaper{id = ").append(id);
        sb.append(", note = ").append(note);
        sb.append(", title = ").append(title);
        sb.append(", numberOfPages = ").append(numberOfPages);
        sb.append(", price = ").append(price);
        sb.append(", monthly = ").append(monthly);
        sb.append(", color = ").append(color);
        sb.append(", publicationDate = ").append(publicationDate);
        sb.append(" }");
        String finalString = sb.toString();

        return finalString;
    }
}
