% t_n_i
% time:
generate_model = 13512;
duration_to_solve_model_us = 1054;
create_model = 29;
% allocatedChunks
allocatedChunks(:,:,1) = [5, 0; 5, 0; 5, 0; 5, 0; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0];
allocatedChunks(:,:,2) = [0, 0; 0, 0; 20, 0; 15, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
allocatedChunks(:,:,3) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 12; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
allocatedChunks(:,:,4) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 67; 0, 67; 0, 28; 0, 0; 0, 0; 20, 0; 20, 0; 0, 0; 0, 0; 20, 0; 3, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
allocatedChunks(:,:,5) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 35; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
allocatedChunks(:,:,6) = [5, 0; 5, 0; 5, 0; 5, 0; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0];
allocatedChunks(:,:,7) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 35; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
allocatedChunks(:,:,8) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 12; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
% non_allocated
non_allocated = [25, 0, 0, 0, 0, 25, 0, 0];
% dl_vio
dl_vio = [0, 0, 0, 0, 0, 0, 0, 0];
% st_vio
st_vio = [0, 0, 0, 0, 0, 50750, 0, 0];
% vioThroughput
vioThroughput = [0, 0, 0, 0, 0, 0, 0, 0];
% non_allo_vio
non_allo_vio = [1400, 0, 0, 0, 0, 1400, 0, 0];
% nChunks
nChunks = [150, 35, 12, 225, 35, 150, 35, 12];
% prefStartTime
prefStartTime = [0, 3, 0, 9, 12, 15, 18, 0];
% deadline
deadline = [30, 4, 100000, 24, 13, 45, 19, 100000];
% availBW
availBW = [30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30; 0, 0, 0, 0, 38, 77, 77, 77, 77, 77, 38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
