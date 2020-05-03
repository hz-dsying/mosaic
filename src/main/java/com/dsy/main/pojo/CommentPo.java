package com.dsy.main.pojo;

public class CommentPo {
    private Integer commentid;

    private User user;

    private Song song;

    private String commentcontent;

    private Integer likescount;
    
    /**
     * 用户是否点赞该评论，1点赞，0未点赞
     */
    private Integer isCheck;

	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

	public Integer getLikescount() {
		return likescount;
	}

	public void setLikescount(Integer likescount) {
		this.likescount = likescount;
	}

	public Integer getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}


    
    

}
