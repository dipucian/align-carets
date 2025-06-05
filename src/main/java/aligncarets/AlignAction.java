package aligncarets;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;

import java.util.List;

public class AlignAction extends AnAction {
    @Override
    public void update(AnActionEvent e) {
        Project project = e.getProject();
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        e.getPresentation().setVisible(project != null && editor != null && editor.getCaretModel().getCaretCount() > 1);
    }

    @Override
    public ActionUpdateThread getActionUpdateThread() {
        // The update method only queries editor state, which is inexpensive, so
        // it can safely run on a background thread.
        return ActionUpdateThread.BGT;
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        Document document = editor.getDocument();
        List<Caret> carets = editor.getCaretModel().getAllCarets();
        int maxColumn = carets.stream().mapToInt(c -> c.getLogicalPosition().column).max().getAsInt();
        WriteCommandAction.runWriteCommandAction(e.getProject(), () -> {
            for (Caret caret : carets) {
                int pad = maxColumn - caret.getLogicalPosition().column;
                if (pad <= 0) {
                    continue;
                }
                int offset = caret.getOffset();
                document.insertString(offset, " ".repeat(pad));
                caret.moveToOffset(offset + pad);
            }
        });
    }
}
