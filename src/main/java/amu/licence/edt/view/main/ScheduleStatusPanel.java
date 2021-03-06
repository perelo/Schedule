package amu.licence.edt.view.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.ViewComponent;

public class ScheduleStatusPanel extends ViewComponent {

    private final String DFLT_LBL_TXT = "vide";

    private JButton btnLeft;
    private JButton btnRight;

    private JPanel pnlStatus;
    private JLabel label;
    private JLabel lblDate;
    private SimpleDateFormat dateFormat;

    public ScheduleStatusPanel(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected JComponent createComponent() {
        JPanel panel = new JPanel(new FlowLayout());

        btnLeft = new JButton("<<");
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLeftActionPerformed(e);
            }
        });

        btnRight = new JButton(">>");
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRightActionPerformed(e);
            }
        });

        label = new JLabel(DFLT_LBL_TXT);

        dateFormat = new SimpleDateFormat("EEE d MMMM yyyy");
        Date d = presenter.scheduleStatusCreating();
        lblDate = new JLabel((d != null) ? dateFormat.format(d) : DFLT_LBL_TXT);

        pnlStatus = new JPanel(new BorderLayout());
        pnlStatus.add(label, BorderLayout.CENTER);
        pnlStatus.add(lblDate, BorderLayout.SOUTH);

        panel.setLayout(new FlowLayout());
        panel.add(btnLeft);
        panel.add(pnlStatus);
        panel.add(btnRight);

        return panel;
    }

    protected void btnLeftActionPerformed(ActionEvent e) {
        presenter.prevWeekButtonPressed();
    }

    protected void btnRightActionPerformed(ActionEvent e) {
        presenter.nextWeekButtonPressed();
    }

    public void setLabelText(String text) {
        label.setText(text != null ? text : DFLT_LBL_TXT);
    }

    public void setDate(Date d) {
        lblDate.setText((d != null) ? dateFormat.format(d) : DFLT_LBL_TXT);
    }

}
