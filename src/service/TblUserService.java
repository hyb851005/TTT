package service;

import java.util.ArrayList;

import dao.TblUserDao;
import model.TblUser;

public class TblUserService {
	public boolean serviceLogin(String username, String password) {
		boolean result = false;
		TblUserDao userDao = new TblUserDao();
		ArrayList<TblUser> userlist = userDao.daoLogin();
		for (int i = 0; i < userlist.size(); i++) {
			if (userlist.get(i).getUsername().equals(username) && userlist.get(i).getPassword().equals(password)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public int serviceAdd(String uid, String username, String password) {
		int result = 0;
		TblUserDao userDao = new TblUserDao();
		result = userDao.daoAdd(uid, username, password);
		return result;
	}
}
