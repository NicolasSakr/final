<?php

include("db_info.php");

$email = $_GET["email"]; 
$password = $_GET["password";]

if (empty($email)) {
    echo("email is missing");
    exit();
    }
    else if(empty($password)){
        echo("Password is missing");
        exit();
    }
    else{
    
        $result = mysqli_query($mysqli, "SELECT * FROM users WHERE email = '".$email ."' ");

        if (mysqli_num_rows($result) == 0) {
            echo("Incorrect Username or password");
            exit();
        }
        else{
            $raw = mysqli_fetch_assoc($result);

            $dbemail = $raw['email'];
            $dbpassword = $raw['password'];
            $response = [];
            if ($dbemail == $email && $password == $dbpassword) {
                $response[] = $raw;
                $json_respnse = json_encode($response);
                echo $json_respnse;
                exit();
            }   
            else{
                echo("Incorrect Username or password");
                exit();
            }
        }
    }
?>