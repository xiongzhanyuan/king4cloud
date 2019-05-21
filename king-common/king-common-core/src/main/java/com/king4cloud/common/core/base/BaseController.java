package com.king4cloud.common.core.base;

import com.king4cloud.common.core.message.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Slf4j
public abstract class BaseController<Bs extends BaseService, M extends BaseModel> {

    @Autowired
    protected Bs baseService;


//    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping
    public DataResponse<M> add(@RequestBody M entity){
//        entity.setCreateTime(LocalDateTime.now());
//        entity.setUpdateTime(LocalDateTime.now());
        baseService.save(entity);
        return new DataResponse<>();
    }
    @GetMapping("/{id}")
    public DataResponse<M> get(@PathVariable String id){
        Object o = baseService.getById(id);
        DataResponse<M> objectResponse = new DataResponse<>();
        if (o!=null){
            objectResponse.setData((M) o);

        }
        return objectResponse;
    }

//    @ApiOperation(value="修改", notes="修改 by id")
    @PutMapping
    public DataResponse<M> update(M entity){
//        entity.setUpdateTime(LocalDateTime.now());
        baseService.updateById(entity);
        return new DataResponse<>();
    }

//    @ApiOperation(value = "删除", notes = "删除")
    @DeleteMapping("/{id}")
    public DataResponse<M> delete(@PathVariable String id){
        baseService.removeById(id);
        return new DataResponse<>();
    }
}
