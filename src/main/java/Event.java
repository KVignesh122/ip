public class Event extends Task {
    protected String time;
    protected int keywordIdx = 0;

    /**
     * Extracts time/day of event.
     *
     * @param inp User input string.
     * @return Time of event.
     */
    public String extractTime(String inp) {
        // Deadline commands by user will contain "/at" substring.
        this.keywordIdx = inp.indexOf("/");
        return inp.substring(keywordIdx + 4);
    }

    /**
     * Returns timing to be appended to task description.
     *
     * @return Event timing input by user, within parentheses.
     */
    public String getTimeString() {
        return "(at: " + this.time + ")";
    }

    /**
     * Constructor for Event subclass.
     *
     * @param eventDescription Name of event task.
     */
    public Event(String eventDescription) {
        super(eventDescription, "event");
        this.time = extractTime(eventDescription);
        super.description = eventDescription.substring(6, this.keywordIdx) + getTimeString();
    }
}
