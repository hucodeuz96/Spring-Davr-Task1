    package com.example.springdavrtask.hucode.service;

    import com.example.springdavrtask.hucode.dto.ApiResponse;
    import com.example.springdavrtask.hucode.dto.GroupDto;
    import com.example.springdavrtask.hucode.dto.ResGroupDto;
    import com.example.springdavrtask.hucode.entity.*;
    import com.example.springdavrtask.hucode.repository.*;
    import com.example.springdavrtask.hucode.util.DateFormatUtil;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.stream.Collectors;

    /**
 * @author "Husniddin Ulachov"
 * @created 9:28 PM on 6/17/2022
 * @project Spring-Davr-Task
 */
@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final StatusRepository statusRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final RoomRepository roomRepository;
    private  final DateFormatUtil dateFormatUtil;



    public Group addGroup(GroupDto groupDto){
        Course course1 = courseRepository.findById(groupDto.getCourseId()).orElseThrow(() -> new RuntimeException("not found course"));
        Teacher teacher = teacherRepository.findById(groupDto.getTeacherId()).orElseThrow(() -> new RuntimeException("not found teacher"));
        Room room = roomRepository.findById(groupDto.getRoomId()).orElseThrow(() -> new RuntimeException("not found room"));
        Status status = statusRepository.findById(groupDto.getStatusId()).orElseThrow(() -> new RuntimeException("not found status"));

        Group group = new Group();
        group.setCourse(course1);
        group.setTeacher(teacher);
        group.setName(groupDto.getName());
        group.setStartDate(dateFormatUtil.parseTime(groupDto.getStartDate()));
        group.setEndDate(dateFormatUtil.parseTime(groupDto.getEndDate()));
        group.setStatus(status);
        group.setRoom(room);

      return  groupRepository.save(group);
    }
    public List<ResGroupDto> getAll() {
        List<Group> groupList = groupRepository.findAll();
       return groupList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

        private ResGroupDto mapToDTO(Group group) {
          return   ResGroupDto.builder()
                    .startDate(String.valueOf(group.getStartDate()))
                    .endDate(String.valueOf(group.getEndDate()))
                    .courseName(group.getCourse().getName())
                    .teacherName(group.getTeacher().getFullName())
                    .roomName(group.getRoom().getName())
                    .groupName(group.getName())
                    .statusName(group.getStatus().getName())
                    .build();
        }

        public Group getOne(Long id){
        return groupRepository.findById(id).orElseThrow(() -> new RuntimeException("group not found"));
    }

    public void deleteById(Long id) {
        groupRepository.deleteById(id);
    }
    public ApiResponse<Group>  updateById(Long id, GroupDto groupDto) {
        final Group[] group = {new Group()};
        Course course2 = courseRepository.findById(groupDto.getCourseId()).orElseThrow(() -> new RuntimeException("not found course"));
        Teacher teacher = teacherRepository.findById(groupDto.getTeacherId()).orElseThrow(() -> new RuntimeException("not found teacher"));
        Room room = roomRepository.findById(groupDto.getRoomId()).orElseThrow(() -> new RuntimeException("not found room"));
        Status status = statusRepository.findById(groupDto.getStatusId()).orElseThrow(() -> new RuntimeException("not found status"));

        groupRepository.findById(id).ifPresentOrElse(
                group1 ->{
                    group1.setRoom(room);
                    group1.setStatus(status);
                    group1.setCourse(course2);
                    group1.setName(groupDto.getName());
                    group1.setTeacher(teacher);
                    group1.setStartDate(dateFormatUtil.parseDate(groupDto.getStartDate()));
                    group1.setEndDate(dateFormatUtil.parseDate(groupDto.getEndDate()));
                    group[0] =group1;
                },
                () -> new ApiResponse<>("Error",false,null));
        Group save = groupRepository.save(group[0]);
        return new ApiResponse<>("Successfully",true,save);
    }
}
