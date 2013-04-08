package amu.licence.edt.model.dao;

import java.util.Date;
import java.util.List;

import amu.licence.edt.model.beans.CRoom;
import amu.licence.edt.model.beans.Group;
import amu.licence.edt.model.beans.Level;
import amu.licence.edt.model.beans.Session;
import amu.licence.edt.model.beans.Teacher;

public interface DAOSession extends DAO<Session> {

    List<Session> findByTeacherPeriod(Teacher t, Date startDate, int days);

    List<Session> executeFindSessionByPeriod(Date startDate, int days);

    List<Session> findByGroupPeriod(Group g, Date startDate, int days);

    List<Session> findByCRoomPeriod(CRoom cr, Date firstWeekDay, int i);

    List<Session> findByLevelPeriod(Level l, Date firstWeekDay, int i);

}
