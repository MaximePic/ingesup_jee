package maBanque.servlet.webService;

import com.fasterxml.jackson.databind.ObjectMapper;
import maBanque.controller.CompteController;
import maBanque.model.CompteEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/v1/compte/*")
public class CompteRest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getRequestURI();
        String idStr = path.substring(path.lastIndexOf('/') + 1);
        int clientId = Integer.parseInt(idStr);

        CompteController compteCtrl = new CompteController();
        List<CompteEntity> listCompteEntities = compteCtrl.getAccountsByClientId(clientId);


        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(mapper.writeValueAsString(listCompteEntities));
    }
}
