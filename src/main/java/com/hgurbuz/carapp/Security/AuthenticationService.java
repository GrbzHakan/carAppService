package com.hgurbuz.carapp.Security;

import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.PasswordAuthentication;
import java.util.Date;
import com.hgurbuz.carapp.Constants.*;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static java.util.Collections.emptyList;

public class AuthenticationService {

    // Add token to Authorization header
    public static void addToken(HttpServletResponse res , String username){
        String JwtToken = Jwts.builder().setSubject(username).
                setExpiration(new Date(System.currentTimeMillis() + Constants.EXPIRATIONTIME)).
                signWith(SignatureAlgorithm.HS512, Constants.SIGNINGKEY).
                compact();

        res.addHeader("Authorization", Constants.PREFIX + "" + JwtToken);
        res.addHeader("Access-Control-Expose-Headers","Authorization");
    }

    // Get token from Authorization Header
    public static Authentication getAuthentication(HttpServletRequest req){
        String token = req.getHeader("Authorization");
        if(token != null)
        {
            String user = Jwts.parser()
                    .setSigningKey(Constants.SIGNINGKEY)
                    .parseClaimsJws(token.replace(Constants.PREFIX,""))
                    .getBody()
                    .getSubject();
            if(user != null)
            {
                return new UsernamePasswordAuthenticationToken(user , null, emptyList());
            }
        }
        return null;


    }


}
