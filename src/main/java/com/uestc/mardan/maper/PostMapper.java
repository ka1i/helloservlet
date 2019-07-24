package com.uestc.mardan.maper;

import java.util.List;
import com.uestc.mardan.domain.Post;

public interface PostMapper {
    List<Post> findAll();
}
