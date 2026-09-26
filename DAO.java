package SS15;

import SS15.connection.ConnectionDB;
import SS15.entity.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public List<Product> getAll(){
        List<Product> list = new ArrayList<>();

        String sql = "{CALL getAllProducts ()}";

        try (
                Connection conn = ConnectionDB.getConnection();
                CallableStatement cs = conn.prepareCall(sql);
                ResultSet rs = cs.executeQuery()
        ) {
            while (rs.next()) {
                Product product = new Product();

                product.setProductID(rs.getInt("Product_Id"));
                product.setProductName(rs.getString("Product_Name"));
                product.setProductPrice(rs.getFloat("Product_Price"));
                product.setProductTitle(rs.getString("Product_Title"));
                product.setProductCreated(
                        rs.getDate("Product_created").toLocalDate()
                );
                product.setProductCatalog(
                        rs.getString("Product_catalog")
                );
                product.setProductStatus(
                        rs.getBoolean("Product_Status")
                );

                list.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Loi: " + e.getMessage());
        }

        return list;
    }

    public boolean checkCatalog(String catalog) {
        String sql = "{CALL sp_check_catalog(?)}";

        try (
                Connection conn = ConnectionDB.getConnection();
                CallableStatement cs = conn.prepareCall(sql)
        ) {
            cs.setString(1, catalog);

            try (ResultSet rs = cs.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.out.println("Loi: " + e.getMessage());
        }

        return false;
    }
}
