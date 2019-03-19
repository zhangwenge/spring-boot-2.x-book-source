package com.tgy.springboot2.xbook.springboot2xbookc6.typehandler;

import com.tgy.springboot2.xbook.springboot2xbookc6.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName SexTypeHandler
 */
@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(value = SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getId());
    }

    //通过列名读取性别
    @Override
    public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int sex = rs.getInt(columnName);
        if(sex != 1 && sex != 2){
            return null;
        }
        return SexEnum.getEnumById(sex);
    }
    //通过下标读取性别
    @Override
    public SexEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int sex = rs.getInt(columnIndex);
        if(sex != 1 && sex != 2){
            return null;
        }
        return SexEnum.getEnumById(sex);
    }

    @Override
    public SexEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int sex = cs.getInt(columnIndex);
        if(sex != 1 && sex != 2){
            return null;
        }
        return SexEnum.getEnumById(sex);
    }
}
