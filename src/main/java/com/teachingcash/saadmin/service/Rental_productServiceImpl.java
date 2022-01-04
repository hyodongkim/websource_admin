package com.teachingcash.saadmin.service;

import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.*;
import com.teachingcash.saadmin.vo.*;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Rental_productServiceImpl implements Rental_productService{


    @Autowired
    FileMapper fileMapper;

    @Autowired
    Rental_productMapper rental_productMapper;

    @Autowired
    SalesConditionMapper salesConditionMapper;

    @Autowired
    LastMonthMapper lastMonthMapper;

    @Autowired
    Config config;

    @Override
    public int selectCntRental_product(Rental_productVO rental_productVO){
        return this.rental_productMapper.selectCntRental_product(rental_productVO);
    }

    @Override
    public int insertRental_product(HttpServletRequest request, Rental_productVO rental_productVO, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5){
        int result = 0;
        int parentId = rental_productVO.getId();

        Map<String, Object> map = new HashMap<String, Object>();

        if (rental_productVO.getDeleteFileSeq1() > 0) {
            map.put("id", rental_productVO.getDeleteFileSeq1());
            fileMapper.deleteFile(map);
        }
        if (rental_productVO.getDeleteFileSeq2() > 0) {
            map.put("id", rental_productVO.getDeleteFileSeq2());
            fileMapper.deleteFile(map); }
        if (rental_productVO.getDeleteFileSeq3() > 0) {
            map.put("id", rental_productVO.getDeleteFileSeq3());
            fileMapper.deleteFile(map);
        }
        if (rental_productVO.getDeleteFileSeq4() > 0) {
            map.put("id", rental_productVO.getDeleteFileSeq4());
            fileMapper.deleteFile(map);
        }
        if (rental_productVO.getDeleteFileSeq5() > 0) {
            map.put("id", rental_productVO.getDeleteFileSeq5());
            fileMapper.deleteFile(map);
        }

        if (rental_productVO.getId() > 0) {
            result = rental_productMapper.update(rental_productVO);
        }else{
            result = rental_productMapper.insertRental_product(rental_productVO);
        }

        if (parentId <= 0) { parentId = getMaxPkRental_product(); }

        salesConditionMapper.deleteSalesCondition(rental_productVO.getId());

        List<SalesConditionVO> salesConditionVOS = rental_productVO.getSalesConditionVOS();
        if(salesConditionVOS != null) {
            System.out.println("salesConditionVOS not null.....");
            System.out.println(salesConditionVOS.size());
            for (int i = 0; i < salesConditionVOS.size(); i++) {
                SalesConditionVO salesConditionVO = (SalesConditionVO) salesConditionVOS.get(i);
                salesConditionVO.setRental_product_id(rental_productVO.getId());
                salesConditionMapper.insertSalesCondition(salesConditionVO);
            }
        }

        List<LastMonthVO> lastMonthVOS = rental_productVO.getLastMonthVOS();
        lastMonthMapper.deleteLastMonth(rental_productVO.getId());
        if(lastMonthVOS != null) {
            System.out.println("lastMonthVOS not null.....");
            System.out.println(lastMonthVOS.size());
            for (int i = 0; i < lastMonthVOS.size(); i++) {
                LastMonthVO lastMonthVO = (LastMonthVO) lastMonthVOS.get(i);
                lastMonthVO.setRental_product_id(rental_productVO.getId());
                lastMonthMapper.insertLastMonth(lastMonthVO);
            }
        }

        if (result > 0) {
            if (file1.getSize() > 0) {
                String product = "rental_brand";
                String originalName = file1.getOriginalFilename();
                String savedName = FileUtils.fileUpload(file1, request, product);
                String uploadPath = config.getUploadPath() + product + "/" + savedName;
                long fileSize = file1.getSize();

                System.out.println("[log]originalName:::" + originalName);
                System.out.println("[log]uploadPath:::" + uploadPath);

                FileVO fvo = new FileVO(parentId, product, originalName, savedName, fileSize, uploadPath);
                fileMapper.insertFile(fvo);
            }
            if (file2.getSize() > 0) {
                String product = "rental_item1";
                String originalName = file2.getOriginalFilename();
                String savedName = FileUtils.fileUpload(file2, request, product);
                String uploadPath = config.getUploadPath() + product + "/" + savedName;
                long fileSize = file2.getSize();

                System.out.println("[log]originalName:::" + originalName);
                System.out.println("[log]uploadPath:::" + uploadPath);

                FileVO fvo = new FileVO(parentId, product, originalName, savedName, fileSize, uploadPath);
                fileMapper.insertFile(fvo);
            }
            if (file3.getSize() > 0) {
                String product = "rental_item2";
                String originalName = file3.getOriginalFilename();
                String savedName = FileUtils.fileUpload(file3, request, product);
                String uploadPath = config.getUploadPath() + product + "/" + savedName;
                long fileSize = file3.getSize();

                System.out.println("[log]originalName:::" + originalName);
                System.out.println("[log]uploadPath:::" + uploadPath);

                FileVO fvo = new FileVO(parentId, product, originalName, savedName, fileSize, uploadPath);
                fileMapper.insertFile(fvo);
            }

            if (file4.getSize() > 0) {
                String product = "rental_item3";
                String originalName = file4.getOriginalFilename();
                String savedName = FileUtils.fileUpload(file4, request, product);
                String uploadPath = config.getUploadPath() + product + "/" + savedName;
                long fileSize = file4.getSize();

                System.out.println("[log]originalName:::" + originalName);
                System.out.println("[log]uploadPath:::" + uploadPath);

                FileVO fvo = new FileVO(parentId, product, originalName, savedName, fileSize, uploadPath);
                fileMapper.insertFile(fvo);
            }

            if (file5.getSize() > 0) {
                String product = "rental_desc";
                String originalName = file5.getOriginalFilename();
                String savedName = FileUtils.fileUpload(file5, request, product);
                String uploadPath = config.getUploadPath() + product + "/" + savedName;
                long fileSize = file5.getSize();

                System.out.println("[log]originalName:::" + originalName);
                System.out.println("[log]uploadPath:::" + uploadPath);

                FileVO fvo = new FileVO(parentId, product, originalName, savedName, fileSize, uploadPath);
                fileMapper.insertFile(fvo);
            }
        }

        return result;
    }

    @Override
    public List<Object> listRental_product(Rental_productVO rental_productVO){
        return this.rental_productMapper.listRental_product(rental_productVO);
    }

    @Override
    public int deleteRental_product(Rental_productVO rental_productVO){
        return this.rental_productMapper.deleteRental_product(rental_productVO);
    }

    @Override
    public Rental_productVO selectRental_product(Rental_productVO rental_productVO){
        return this.rental_productMapper.selectRental_product(rental_productVO);
    }

    @Override
    public int update(Rental_productVO rental_productVO){
        return this.rental_productMapper.update(rental_productVO);
    }

    @Override
    public int getMaxPkRental_product() {
        return this.rental_productMapper.getMaxPkRental_product();
    }

    @Override
    public List<RentalAgreementVO> selectRentalAgreement(RentalAgreementVO rentalAgreementVO){ return this.rental_productMapper.selectRentalAgreement(rentalAgreementVO);}

    @Override
    public int insertRentalAgreement(RentalAgreementVO rentalAgreementVO){ return this.rental_productMapper.insertRentalAgreement(rentalAgreementVO);}

    @Override
    public List<RentalLastmonth> selectRentalLastmonth(RentalLastmonth rentalLastmonth){ return this.rental_productMapper.selectRentalLastmonth(rentalLastmonth);}

    @Override
    public int insertRentalLastmonth(RentalLastmonth rentalLastmonth){ return this.rental_productMapper.insertRentalLastmonth(rentalLastmonth);}

    @Override
    public int deleteRentalAgreement(RentalAgreementVO rentalAgreementVO){ return this.rental_productMapper.deleteRentalAgreement(rentalAgreementVO);}

    @Override
    public int deleteRentalLastmonth(RentalLastmonth rentalLastmonth){ return this.rental_productMapper.deleteRentalLastmonth(rentalLastmonth);}
}
