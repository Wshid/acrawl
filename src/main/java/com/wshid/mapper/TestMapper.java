package com.wshid.mapper;

import com.wshid.mydto.TestDTO;

import java.util.List;

/**
 * @author wshid
 * @project acrawl
 * @date 2018. 3. 18. PM 11:53
 */
public interface TestMapper {
    public List<TestDTO> selectUsers();
    public void insertUser(TestDTO data);
}
