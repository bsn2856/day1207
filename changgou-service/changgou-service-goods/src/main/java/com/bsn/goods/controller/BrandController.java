package com.bsn.goods.controller;

import com.bsn.entity.Result;
import com.bsn.entity.StatusCode;
import com.bsn.goods.pojo.Brand;
import com.bsn.goods.service.BrandService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public Result<Brand> fandAll(){
        List<Brand> brandList=brandService.findAll();
        return new Result<Brand>(true, StatusCode.OK,"查询成功",brandList);
    }

    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id){
        Brand brand=brandService.findById(id);
        return new Result<Brand>(true,StatusCode.OK,"查询成功！",brand);
    }

    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Brand brand,@PathVariable Integer id){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id){
        brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @PostMapping(value = "/search")
    public Result<Brand> findList(@RequestBody(required = false) Brand brand){
        List<Brand> list=brandService.findList(brand);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Brand brand, @PathVariable  int page, @PathVariable  int size){
        //执行搜索
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

}
