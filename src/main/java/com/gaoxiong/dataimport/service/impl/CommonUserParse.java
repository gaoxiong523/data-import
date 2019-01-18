package com.gaoxiong.dataimport.service.impl;

import com.gaoxiong.dataimport.model.User;
import com.gaoxiong.dataimport.service.UserParse;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gaoxiong
 * @ClassName CommonUserParse
 * @Description TODO
 * @date 2019/1/17 18:21
 */
@Service
public class CommonUserParse implements UserParse {
    @Override
    public User parse ( String line ) {
        String[] strings = line.split("#");
        if (strings.length != 3) {
            return null;
        }
        return User.builder()
                .uid(Long.valueOf(strings[0]))
                .name(strings[1])
                .birthAt(getDate(strings[2]))
                .build()
                ;
    }

    private Date getDate ( String string ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
