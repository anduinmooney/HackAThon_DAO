package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oMemberDao implements MemberDao {
    private final Sql2o sql2o;

    public Sql2oMemberDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Member member) {
        String sql = "INSERT INTO members (hackMemberName, hackMemberId) VALUES (:hackMemberName, :hackMemberId)"; //here
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .addParameter("hackMemberName", member.getMemberName())
                    .addParameter("hackMemberId", member.getHackMemberId())
                    .addColumnMapping("HACKMEMBERNAME", "hackMemberName")
                    .addColumnMapping("HACKMEMBERID", "hackMemberId")

                    .executeUpdate()
                    .getKey();
            member.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Member> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM members")
                    .executeAndFetch(Member.class);
        }
    }

    @Override
    public Member findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM members WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Member.class);
        }
    }

    @Override
    public void update(int id, String newHackMemberName, int newHackMemberId) {
        String sql = "UPDATE members SET hackMemberName = :name WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", newHackMemberName)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from members WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllMembers() {
        String sql = "DELETE from members";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


}
