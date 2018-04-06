package com.b2berp.b2brepository.dao;

import com.b2berp.b2bmodel.core.User;

public interface UserDAO extends GenericDao<User, Long> {

    /**
     * Find user by username, Mostly used with userlogin
     *
     * @param getRoles used to retrieve user along with all pre-loaded
     * associated roles.
     * @return
     */
    public User findUserByUserName(String username, boolean getRoles);
}
