import java.util.Deque;
import java.util.LinkedList;

public class WebsiteHistory {
    private Deque<String> history = new LinkedList<>();

    public void visitSite(String site) {
        history.addFirst(site);
    }

    public String back(int steps) {
        return history.size() >= steps ? history.stream().skip(history.size() - steps).findFirst().orElse(null) : null;
    }

    public Deque<String> getHistory() {
        return history;
    }

    public static void main(String[] args) {
        WebsiteHistory historyTracker = new WebsiteHistory();

        historyTracker.visitSite("google.com");
        historyTracker.visitSite("youtube.com");
        historyTracker.visitSite("github.com");

        System.out.println("Most recent visits: ");
        System.out.println(historyTracker.getHistory());

        System.out.println("Visited sites in reverse order: ");
        for (String site : historyTracker.getHistory()) {
            System.out.print(site + " ");
        }
        System.out.println();

        System.out.println("Back one step: " + historyTracker.back(1));
        System.out.println("Back two steps: " + historyTracker.back(2));
        System.out.println("Back more than available: " + historyTracker.back(10));
    }
}