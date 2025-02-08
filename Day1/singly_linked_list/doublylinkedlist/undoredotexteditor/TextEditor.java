package doublylinkedlist.undoredotexteditor;

class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int historySize;
    private int historyCount;

    public TextEditor(int historySize) {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.historySize = historySize;
        this.historyCount = 0;
    }

    public void addState(String content) {
        TextState newState = new TextState(content);

        if (historyCount >= historySize) {
            removeOldestState();
        }

        if (tail != null) {
            tail.next = newState;
            newState.prev = tail;
        }

        tail = newState;
        if (head == null) {
            head = newState;
        }
        current = tail;

        historyCount++;
    }

    private void removeOldestState() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            historyCount--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more states to undo.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more states to redo.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }

    public void displayHistory() {
        TextState temp = head;
        System.out.println("Text History: ");
        while (temp != null) {
            System.out.println(temp.content);
            temp = temp.next;
        }
    }
}

