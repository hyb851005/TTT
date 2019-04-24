package service;

import java.util.ArrayList;

import dao.TblCommyDao;
import model.TblCommy;

public class TblCommyService {
	public ArrayList<TblCommy> serviceInit() {
		TblCommyDao tblCommyDao = new TblCommyDao();
		ArrayList<TblCommy> commylist = new ArrayList<TblCommy>();
		commylist = tblCommyDao.daoInit();
		if (commylist.size() == 0) {
			TblCommy commy = new TblCommy();
			commy.setUserId("");
			commylist.add(commy);
		}
		return commylist;
	}

	public ArrayList<TblCommy> serviceQuest(String cardNo) {
		TblCommyDao tblCommyDao = new TblCommyDao();
		ArrayList<TblCommy> commylist = new ArrayList<TblCommy>();
		commylist = tblCommyDao.daoQuest(cardNo);
		if (commylist.size() == 0) {
			TblCommy commy = new TblCommy();
			commy.setUserId("");
			commylist.add(commy);
		}
		return commylist;
	}

	public boolean serviceDelete(String cardNo) {
		TblCommyDao tblCommyDao = new TblCommyDao();
		int result;
		result = tblCommyDao.daoDelete(cardNo);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public int serviceAdd(String id, String createUser, String userId, String orgId, String name, String cardNo,
			String phone, String addr, String statuss, String sexx, String birthday, String age, String bakk) {
		TblCommyDao tblCommyDao = new TblCommyDao();
		int result;
		result = tblCommyDao.daoAdd(id, createUser, userId, orgId, name, cardNo, phone, addr, statuss, sexx, birthday,
				age, bakk);
		return result;
	}

	public int serviceUpdate(String cardNo, String userId, String orgId, String name, String newCardNo, String phone,
			String addr, String statuss, String sexx, String birthday, String age, String bakk) {
		TblCommyDao tblCommyDao = new TblCommyDao();
		int result;
		result = tblCommyDao.daoUpdate(cardNo, userId, orgId, name, newCardNo, phone, addr, statuss, sexx, birthday,
				age, bakk);
		return result;
	}
}
