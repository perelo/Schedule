package amu.licence.edt.presenter;

import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import amu.licence.edt.controller.Controller;
import amu.licence.edt.model.ModelObserver;
import amu.licence.edt.model.Schedule;
import amu.licence.edt.model.beans.Admin;
import amu.licence.edt.model.beans.CRoom;
import amu.licence.edt.model.beans.CRoomType;
import amu.licence.edt.model.beans.Group;
import amu.licence.edt.model.beans.Level;
import amu.licence.edt.model.beans.Teacher;
import amu.licence.edt.view.View;
import amu.licence.edt.view.renderers.CRoomRenderer;
import amu.licence.edt.view.renderers.CRoomTypeRenderer;
import amu.licence.edt.view.renderers.ClassBasedDDR;
import amu.licence.edt.view.renderers.DMTNUserObjectBasedRenderer;
import amu.licence.edt.view.renderers.GroupRenderer;
import amu.licence.edt.view.renderers.LevelRenderer;
import amu.licence.edt.view.renderers.TeacherRenderer;

public class Presenter implements ModelObserver {

    private ClassBasedDDR classBasedDDR;

    private View view;
    private Controller controller;

    public Presenter(Controller controller) {
        this.classBasedDDR = new ClassBasedDDR();
        classBasedDDR.addRenderer(Teacher.class, new TeacherRenderer());
        classBasedDDR.addRenderer(Level.class, new LevelRenderer());
        classBasedDDR.addRenderer(CRoom.class, new CRoomRenderer());
        classBasedDDR.addRenderer(CRoomType.class, new CRoomTypeRenderer());
        classBasedDDR.addRenderer(Group.class, new GroupRenderer());
        this.controller = controller;
        this.view = new View(this);
    }

    public void showView() {
        view.getMainFrame().getFrame().setVisible(true);
    }

    @Override
    public void userChanged(Admin user) {
        if (user == null) {
            view.getMainFrame().getAdminStatusPanel().displayPublicUserStatus();
        }
        else {
            view.getMainFrame().getAdminStatusPanel().displayAdminUser(user);
        }
        view.getMainFrame().getFrame().pack();
    }

    @Override
    public void scheduleChanged(Schedule schedule) {
    }

    public void connectButtonPressed() {
        view.getLoginForm().getComponent().setVisible(true);
    }

    public void disconnectButtonPressed() {
        controller.disconnectionRequested();
    }

    public void validateLoginButtonPressed(String login, String password) {
        if (controller.validateLoginRequested(login, password)) {
            view.getLoginForm().getComponent().setVisible(false);
            view.getLoginForm().refresh();
        }
        else {
            view.getLoginForm().showErrorLbl(true);
            view.getLoginForm().clearTextFields();
        }
    }

    public void manageLevelButtonPressed(String levelCode) {
        // TODO
    }

    public TreeNode scheduleTreeCreating() {
        return controller.scheduleRootNodeRequested();
    }

    public void treePathChanged(TreePath path) {
        @SuppressWarnings("unused")
        DMTNUserObjectBasedRenderer dmtnRenderer = new DMTNUserObjectBasedRenderer(classBasedDDR);
//        System.out.println(dmtnRenderer.getStrRender(path.getLastPathComponent()));
    }

    public ClassBasedDDR getClassBasedDDR() {
        return classBasedDDR;
    }

}
