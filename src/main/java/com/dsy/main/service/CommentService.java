package com.dsy.main.service;

import java.util.List;

import com.dsy.main.pojo.Comment;
import com.dsy.main.pojo.CommentVo;
import com.dsy.main.util.PageBean;

public interface CommentService {

	/**
	 * 根据用户删除评论
	 * @param userid
	 */
	void deleteByUser(Integer userid);

	/**
	 * 根据歌曲删除评论
	 * @param songid
	 */
	void deleteBySong(Integer songid);

	/**
	 * 根据歌曲搜索评论
	 * @param songid
	 * @return
	 */
	List<Comment> selectBySong(Integer songid);

	/**
	 * 根据歌曲ids搜索评论
	 * @param ids
	 */
	List<Comment> selectBySongids(List<Integer> ids);

	/**
	 * 查询所有评论
	 * @return
	 */
	List<Comment> queryAllComment();

	/**
	 * 根据id删除评论
	 * @param commentid
	 */
	void deleteById(Integer commentid);

	/**
	 * 后台管理分页查询评论
	 * @param songname
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean<CommentVo> findPageBean(List<Integer> ids, Integer currentPage, Integer pageSize);

	/**
	 * 根据id查找评论
	 * @param commentid
	 * @return
	 */
	Comment selectByid(Integer commentid);

	/**
	 * 修改评论
	 * @param comment
	 */
	void update(Comment comment);

	/**
	 * 插入评论
	 * @param comment
	 */
	void insert(Comment comment);

}
