<?php 

class Database 
{
    public $conn;

    //localhost
    private $servername = "DESKTOP-JTI5USI\SQLEXPRESS";
 
    public function getConnection(){
 
        $this->conn = null;

        try{
			$this->conn = new PDO("sqlsrv:Server=$this->servername;Database=StugerDB", "", "");
			$this->conn->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION );
		}
		catch(Exception $e){
			die(print_r( $e->getMessage() ) );
		}
 
        return $this->conn;
    }
}

?>