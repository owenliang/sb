package cc.yuerblog.sb.service.impl;

import cc.yuerblog.sb.entity.User;
import cc.yuerblog.sb.mapper.articledb.ArticleMapper;
import cc.yuerblog.sb.mapper.userdb.UserMapper;
import cc.yuerblog.sb.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void edit() {
        articleMapper.insertArticle("sb", ".....");
    }
}
