import models.Vote;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Bootstrap extends Job {

    @Override
    public void doJob() throws Exception {

        for (int i = 0; i < 81; i++) {

            for (int j = 0; j < Math.floor(Math.random() * 10) + 1; j++)
                new Vote("AKP", String.valueOf(i)).save();
            for (int j = 0; j < Math.floor(Math.random() * 10) + 1; j++)
                new Vote("CHP", String.valueOf(i)).save();
            for (int j = 0; j < Math.floor(Math.random() * 10) + 1; j++)
                new Vote("MHP", String.valueOf(i)).save();
            for (int j = 0; j < Math.floor(Math.random() * 10) + 1; j++)
                new Vote("Diger", String.valueOf(i)).save();
        }
    }
}
