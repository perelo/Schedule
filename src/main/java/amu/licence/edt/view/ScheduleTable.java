package amu.licence.edt.view;

import javax.swing.JComponent;
import javax.swing.JTable;

import amu.licence.edt.model.beans.TU;
import amu.licence.edt.presenter.SchedulePresenter;

public class ScheduleTable extends ViewComponent {

    public ScheduleTable(SchedulePresenter presenter) {
        super(presenter);
    }

        @Override
        public JComponent createComponent() {
            JTable table = new JTable(new ScheduleTableModel());
            table.setDefaultRenderer(TU.class, new ScheduleTableCellRenderer());
            return table;
        }

}
