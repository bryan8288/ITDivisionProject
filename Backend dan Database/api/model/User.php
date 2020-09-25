<?php 

class User
{
	private $conn;
	private $table_name = "MsUser";

	public $UserID;
	public $UserName;
	public $UserEmail;
	public $UserPhone;
	public $UserDOB;
	public $UserPassword;

	public function __construct($db)
	{
		$this->conn = $db;
	}

	function read(){
 
	    $query = "SELECT * FROM ".$this->table_name;
	 
	    $stmt = $this->conn->prepare($query);
	    $stmt->execute();

	    return $stmt;
	}

	function login(){

		$query = "EXEC sp_LoginUser '".$this->UserEmail."', '".$this->UserPassword."'";

		$stmt = $this->conn->prepare($query);

		$this->UserEmail = htmlspecialchars(strip_tags($this->UserEmail));
		$this->UserPassword = htmlspecialchars(strip_tags($this->UserPassword));

		$stmt->execute();

		return $stmt;
	}

	function register(){
		$query = "EXEC sp_NewUser '".$this->UserName."', '".$this->UserEmail."', '".$this->UserPhone."', '".$this->UserDOB."', '".$this->UserPassword."'";

		$stmt = $this->conn->prepare($query);

		if($stmt->execute()){
			echo json_encode(array("Message" => "Register success!"));
		}
	}

	function isExist(){
		$query = "EXEC sp_CheckUser '".$this->UserName."', '".$this->UserEmail."'";

		$stmt = $this->conn->prepare($query);
		$stmt->execute();

		return $stmt;
	}
}

?>