package algo_expert.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given three inputs, all of which are instances of OrgChart class that have a directReports property
 * pointing to their direct reports. The first input is the top manager in an organization chart (i.e. the only one instance that isn't
 * anybody else's direct report), and the other two inputs are reports in the organization chart.
 */
public class LowestCommonManager {

    public static void main(String[] args) {
        OrgChart orgChartA = new OrgChart('A');
        OrgChart orgChartB = new OrgChart('B');
        OrgChart orgChartC = new OrgChart('C');

        OrgChart orgChartD = new OrgChart('D');
        OrgChart orgChartE = new OrgChart('E');

        OrgChart orgChartF = new OrgChart('F');
        OrgChart orgChartG = new OrgChart('G');

        OrgChart orgChartH = new OrgChart('H');
        OrgChart orgChartI = new OrgChart('I');



        orgChartA.addDirectReports(new OrgChart[]{orgChartB, orgChartC});
        orgChartB.addDirectReports(new OrgChart[]{orgChartD, orgChartE});
        orgChartC.addDirectReports(new OrgChart[]{orgChartF, orgChartG});
        orgChartD.addDirectReports(new OrgChart[]{orgChartH, orgChartI});

        System.out.println(getOrgInfo(orgChartA, orgChartE, orgChartI));

    }

    public static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        int numImportantReports = 0;
        for (OrgChart directReport: manager.directReports) {
            OrgInfo orgInfo = getOrgInfo(directReport, reportOne, reportTwo);
            if (orgInfo.lowestCommonManager != null) return orgInfo;
            numImportantReports += orgInfo.numImportantReports;
        }
        if (manager == reportOne || manager == reportTwo) numImportantReports++;
        OrgChart lowestCommonManager = numImportantReports == 2 ? manager : null;
        OrgInfo newOrgInfo           = new OrgInfo(lowestCommonManager, numImportantReports);
        return newOrgInfo;
    }


    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<>();
        }

        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport: directReports) {
                this.directReports.add(directReport);
            }
        }
    }

    static class OrgInfo {
        public OrgChart lowestCommonManager;
        int numImportantReports;

        OrgInfo(OrgChart lowestCommonManager, int numImportantReports) {
            this.lowestCommonManager = lowestCommonManager;
            this.numImportantReports = numImportantReports;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("OrgInfo{");
            sb.append("lowestCommonManager=").append(lowestCommonManager.name);
            sb.append(", numImportantReports=").append(numImportantReports);
            sb.append('}');
            return sb.toString();
        }
    }
}
