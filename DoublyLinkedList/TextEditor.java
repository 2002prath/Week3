package DoublyLinkedList;

class TextEditor {

    // Doubly Linked List Node
    static class TextState {
        String text;
        TextState next;
        TextState prev;

        TextState(String text) {
            this.text = text;
            this.next = null;
            this.prev = null;
        }
    }

    private TextState current; // Pointer to the current text state
    private int historySize = 0;
    private final int MAX_HISTORY = 10; // Limit history to last 10 states

    // Add a new text state (When user types or performs an action)
    public void addTextState(String newText) {
        TextState newState = new TextState(newText);

        if (current == null) {
            current = newState;
        } else {
            // Remove forward history when new text is added
            current.next = null;

            // Link the new state
            newState.prev = current;
            current.next = newState;
            current = newState;
        }

        // Maintain max history size (Remove oldest)
        if (historySize == MAX_HISTORY) {
            removeOldestState();
        } else {
            historySize++;
        }

        System.out.println("✅ Text Updated: " + current.text);
    }

    // Undo (Revert to the previous state)
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("❌ No previous state to undo.");
            return;
        }
        current = current.prev;
        System.out.println("🔄 Undo: " + current.text);
    }

    // Redo (Reapply an undone state)
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("❌ No next state to redo.");
            return;
        }
        current = current.next;
        System.out.println("🔄 Redo: " + current.text);
    }

    // Display current text state
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("📜 No text available.");
        } else {
            System.out.println("\n📌 Current Text: " + current.text);
        }
    }

    // Remove the oldest state if history exceeds MAX_HISTORY
    private void removeOldestState() {
        TextState temp = current;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        if (temp.next != null) {
            temp.next.prev = null; // Remove oldest state
        }
        System.out.println("⚠️ Oldest history state removed to maintain limit.");
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addTextState("Hello");
        editor.addTextState("Hello, World");
        editor.addTextState("Hello, World!");
        editor.displayCurrentState();

        editor.undo();
        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addTextState("Hello, Java!");
        editor.addTextState("Welcome to Text Editor!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();
    }
}

