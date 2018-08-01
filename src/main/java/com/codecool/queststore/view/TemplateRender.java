package com.codecool.queststore.view;

import com.codecool.queststore.DAO.ClassDAO;
import com.codecool.queststore.model.classes.CodecoolClass;
import com.codecool.queststore.model.shop.artifact.Artifact;
import com.codecool.queststore.model.shop.quest.Quest;
import com.codecool.queststore.model.user.Role;
import com.codecool.queststore.model.user.User;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.util.List;

public class TemplateRender implements RenderInteface {

    @Override
    public String RenderClassPage(User currentUser, List<CodecoolClass> classes) {
        TemplateModelInterface tmi = new TemplateModelHandler();
        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/class.html");

        // create a model that will be passed to a template
        JtwigModel model = tmi.getClassModel(currentUser, classes);

        return template.render(model);
    }

    @Override
    public String RenderClassPage(User currentUser, List<CodecoolClass> classes, CodecoolClass targetClass) {
        TemplateModelInterface tmi = new TemplateModelHandler();
        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/class.html");

        // create a model that will be passed to a template
        JtwigModel model = tmi.getClassModel(currentUser, classes, targetClass);

        return template.render(model);
    }

    @Override
    public String RenderProfilePage(User currentUser, User profile, List<CodecoolClass> classes) {
        /* Mentor profile model:
         *  currentUser - active user
         *  profile - user with data we want to show
         *  classes - list of Codecool Classes assigned to user
         */

        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/profile.html");
        TemplateModelInterface tmi = new TemplateModelHandler();

        //render from args
        return template.render(tmi.getProfileMentorModel(currentUser, profile, classes));
    }

    @Override
    public String RenderProfilePage(User currentUser, User profile, CodecoolClass ccClass, List<Artifact> items) {
        /* Student profile model:
         *  currentUser - active user
         *  profile - user with data we want to show
         *  ccClass - CodecoolClass of user
         *  items - list of user's Artifacts
         */

        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/profile.html");
        TemplateModelInterface tmi = new TemplateModelHandler();

        // render from args
        return template.render(tmi.getProfileStudentModel(currentUser, profile, ccClass, items));
    }

    public String RenderMentorListPage(User currentUser, List<User> users) {
        /* User list model:
         *  currentUser - active user
         *  items - list of user's
         */
        TemplateModelInterface tmi = new TemplateModelHandler();

        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/userList.html");

        return template.render(tmi.getMentorsListModel(currentUser, users));
    }

    public String RenderStudentListPage(User currentUser, List<User> users) {
        /* User list model:
         *  currentUser - active user
         *  items - list of user's
         */
        TemplateModelInterface tmi = new TemplateModelHandler();

        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/userList.html");

        return template.render(tmi.getMentorsListModel(currentUser, users));
    }

    @Override
    public String RenderShopPage(User currentUser, List<Artifact> artifacts) {
        TemplateModelInterface tmi = new TemplateModelHandler();

        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/shop.html");

        return template.render(tmi.getArtifactModel(currentUser, artifacts));
    }

    @Override
    public String RenderQuestPage(User currentUser, List<Quest> quests) {
        TemplateModelInterface tmi = new TemplateModelHandler();

        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/quests.html");

        return template.render(tmi.getQuestModel(currentUser, quests));
    }

    public static void main(String[] args) {
        User currentUser = new User("Piotr", "Kaminski", "pk@o2.pl", "sss", 5, Role.MENTOR);
        List<CodecoolClass> classes = new ClassDAO().getClasses();
        RenderInteface renderInteface = new TemplateRender();
        System.out.println(renderInteface.RenderClassPage(currentUser, classes, classes.get(1)));
    }
}