<?php  

class ForumReply
{
	private $conn;
	private $table_name = "TrForumReply";

	public $ForumReplyID;
	public $ReplyMaker;
	public $ForumReplyDescription;
	public $ForumScore;

	public $ForumID;

	function __construct($db)
	{
		$this->conn = $db;
	}

	function updateForumReply(){
		$query = "EXEC sp_updateForumReply";

		$stmt = $this->conn->prepare($query);
	    if($stmt->execute()){
	    	return true;
	    }

	    return false;
	}

	function getForumReply(){
		$query = "EXEC sp_getForumReply '".$this->ForumID."'";

	    $stmt = $this->conn->prepare($query);
	    $stmt->execute();

	    return $stmt;
	}

	function newForumReply(){
		$query = "EXEC sp_newForumReply '".$this->ReplyMaker."', '".$this->ForumReplyDescription."', '".$this->ForumID."'";

		$stmt = $this->conn->prepare($query);
		if($stmt->execute()){
			return true;
		}

		return false;
	}
}

?>