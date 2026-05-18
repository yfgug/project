package com.example.dormitory.service;
import com.example.dormitory.entity.Notice;
import com.example.dormitory.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoticeService {
    @Autowired private NoticeMapper noticeMapper;

    public List<Notice> getAllNotices() { return noticeMapper.findAll(); }

    public boolean addNotice(Notice notice) { return noticeMapper.insert(notice) > 0; }

    public boolean updateNotice(Notice notice) { return noticeMapper.update(notice) > 0; }

    public boolean deleteNotice(Integer id) { return noticeMapper.deleteById(id) > 0; }
}
