package com.example.dormitory.service;
import com.example.dormitory.entity.Repair;
import com.example.dormitory.mapper.RepairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RepairService {
    @Autowired private RepairMapper repairMapper;
    public List<Repair> getAllRepairs() { return repairMapper.findAll(); }
    public boolean addRepair(Repair repair) { repair.setStatus("待处理"); return repairMapper.insert(repair) > 0; }
    public boolean resolveRepair(Integer id) { return repairMapper.resolve(id) > 0; }
    public boolean deleteRepair(Integer id) { return repairMapper.deleteById(id) > 0; }
}