import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../services/api";

function LoginPage() {

  const navigate = useNavigate();

  const [email,setEmail]=useState("");
  const [password,setPassword]=useState("");
  const [loading,setLoading]=useState(false);

  async function login(){

    try{

      setLoading(true);

      console.log("EMAIL =",email);
      console.log("PASSWORD =",password);

      const response = await api.post("/auth/login",{
        email,
        password
      });

      console.log("SUCCESS",response.data);

      localStorage.setItem("token",response.data.token);

      alert("Login Successful");

      navigate("/dashboard");

    }catch(error){

      console.log("FULL ERROR",error);

      console.log("STATUS",error?.response?.status);

      console.log("DATA",error?.response?.data);

      alert("Invalid Email or Password");

    }finally{

      setLoading(false);

    }

  }

  return (

    <div style={{
      height:"100vh",
      display:"flex",
      justifyContent:"center",
      alignItems:"center",
      background:"#0f172a"
    }}>

      <div style={{
        width:"380px",
        background:"#fff",
        padding:"35px",
        borderRadius:"12px"
      }}>

        <h1 style={{textAlign:"center"}}>SkillBridge AI</h1>

        <p style={{textAlign:"center"}}>
          AI Career Platform
        </p>

        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e)=>setEmail(e.target.value)}
        />

        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e)=>setPassword(e.target.value)}
        />

        <button
          onClick={login}
          disabled={loading}
        >
          {loading ? "Logging..." : "Login"}
        </button>

      </div>

    </div>

  );

}

export default LoginPage;
