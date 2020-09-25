<?php  

class ForumGeneral
{
	private $conn;
	private $table_name = "TrForumGeneral";

	public $ForumID;
	public $ForumThreadMaker;
	public $ForumDescription;
	
	public $JurusanName;
	public $MaPelName;
	
	function __construct($db)
	{
		$this->conn = $db;
	}

	function getForumThread(){
		$query = "EXEC sp_getForumThread";

	    $stmt = $this->conn->prepare($query);
	    $stmt->execute();

	    return $stmt;
	}

	function newForumThread(){
		$query = "EXEC sp_newForumThread '".$this->ForumThreadMaker."', '".$this->ForumDescription."', '".$this->JurusanName."', '".$this->MaPelName."'";

		$stmt = $this->conn->prepare($query);
		if($stmt->execute()){
			return true;
		}

		return false;
	}
}

?>