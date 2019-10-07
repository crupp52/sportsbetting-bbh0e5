package Models;

public class Bet {
    private String description;
    private SportEvent event;

    public Bet(String description, SportEvent event) {
        this.description = description;
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public SportEvent getEvent() {
        return event;
    }
}
