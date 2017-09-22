package courseLookr.repository;

import courseLookr.pojo.Package;

import java.util.List;

public interface PackageRepository {
    public Package getPackage(int id);
    List<Package> getPackagesForProgram(int programId);
}
