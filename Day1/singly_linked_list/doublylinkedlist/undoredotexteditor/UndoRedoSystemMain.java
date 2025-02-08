package doublylinkedlist.undoredotexteditor;

public class UndoRedoSystemMain {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(5);

        editor.addState("Hello");
        editor.addState("Hello, World!");
        editor.addState("Hello, World! How are you?");
        editor.addState("Hello, World! How are you? I am fine.");
        editor.addState("Hello, World! How are you? I am fine. Thanks for asking!");

        editor.displayCurrentState();

        editor.undo();
        editor.undo();
        editor.redo();
        editor.undo();
        editor.undo();
        editor.undo();

        editor.displayHistory();
    }
}
