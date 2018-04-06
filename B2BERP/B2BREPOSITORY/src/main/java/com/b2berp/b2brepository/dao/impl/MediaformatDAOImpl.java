package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.MediaformatDAO;
import com.b2berp.b2bmodel.core.Mediaformat;

public class MediaformatDAOImpl extends GenericDaoImpl<Mediaformat, Long> implements MediaformatDAO {

    public static MediaformatDAOImpl mediaformatDAOImpl = new MediaformatDAOImpl();

    private MediaformatDAOImpl() {
    }

    public static MediaformatDAOImpl getInstance() {
        return mediaformatDAOImpl;
    }
}
