package me.jcala.jmooc.service;

import me.jcala.jmooc.entity.Chapter;
import me.jcala.jmooc.entity.Course;
import me.jcala.jmooc.entity.Lesson;
import me.jcala.jmooc.repository.ChapterRepository;
import me.jcala.jmooc.repository.CourserRepository;
import me.jcala.jmooc.service.inter.CrsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CrsSerImpl implements CrsSer{

    private CourserRepository courserRepository;

    private ChapterRepository chapterRepository;

    @Autowired
    public CrsSerImpl(CourserRepository courserRepository, ChapterRepository chapterRepository) {
        this.courserRepository = courserRepository;
        this.chapterRepository = chapterRepository;
    }

    @Override
    public int addCourse(Course course) {
       return courserRepository.save(course).getId();
    }

    @Override
    public Set<Chapter> getChapterList(int crsId) {
        return courserRepository.findById(crsId).getChapters();
    }

    @Override
    public Set<Lesson> getLessonList(int chpId) {
        return chapterRepository.findById(chpId).getLessons();
    }
}