% t_n_i
% time:
generate_model = 13686;
duration_to_solve_model_us = 1118;
create_model = 57;
% allocatedChunks
allocatedChunks(:,:,1) = [5, 0, 0, 0, 0, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 5, 0, 0; 0, 0, 0, 0, 0, 5, 0, 0; 0, 0, 0, 0, 0, 5, 0, 0; 0, 0, 0, 0, 0, 5, 0, 0; 0, 0, 0, 0, 0, 5, 0, 0; 0, 0, 0, 0, 0, 5, 0, 0; 0, 0, 0, 0, 0, 5, 0, 0; 0, 0, 0, 5, 0, 0, 0, 0; 0, 0, 0, 5, 0, 0, 0, 0; 0, 0, 0, 5, 0, 0, 0, 0; 0, 0, 0, 5, 0, 0, 0, 0; 0, 0, 5, 0, 0, 0, 0, 0; 0, 0, 5, 0, 0, 0, 0, 0; 0, 0, 5, 0, 0, 0, 0, 0; 0, 0, 5, 0, 0, 0, 0, 0; 0, 0, 5, 0, 0, 0, 0, 0; 0, 0, 5, 0, 0, 0, 0, 0; 0, 0, 5, 0, 0, 0, 0, 0; 0, 0, 5, 0, 0, 0, 0, 0; 0, 0, 5, 0, 0, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0];
allocatedChunks(:,:,2) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 9, 0, 0; 0, 0, 0, 0, 0, 24, 0, 0; 0, 0, 0, 0, 0, 2, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
allocatedChunks(:,:,3) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 12, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
allocatedChunks(:,:,4) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 45, 0, 0, 0, 0, 0; 0, 0, 57, 0, 0, 0, 0, 0; 0, 0, 57, 0, 0, 0, 0, 0; 0, 0, 57, 0, 0, 0, 0, 0; 0, 0, 57, 0, 0, 0, 0, 0; 0, 0, 36, 0, 0, 0, 0, 0; 39, 0, 0, 0, 0, 0, 0, 0; 34, 0, 0, 0, 0, 0, 0, 0; 34, 0, 0, 0, 0, 0, 0, 0; 34, 0, 0, 0, 0, 0, 0, 0];
% non_allocated
non_allocated = [50, 0, 0, 0];
% dl_vio
dl_vio = [0, 0, 0, 0];
% st_vio
st_vio = [0, 0, 0, 474];
% vioThroughput
vioThroughput = [0, 0, 0, 0];
% non_allo_vio
non_allo_vio = [2800, 0, 0, 0];
% nChunks
nChunks = [175, 35, 12, 450];
% prefStartTime
prefStartTime = [0, 6, 0, 18];
% deadline
deadline = [35, 7, 100000, 48];
% availBW
availBW = [39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 22, 33, 33, 33, 33, 33, 33, 22, 11, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 41, 62, 62, 62, 62, 62, 62, 41, 20, 0, 0, 0; 0, 0, 0, 0, 0, 0, 21, 42, 64, 64, 64, 64, 64, 64, 42, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 38, 58, 58, 58, 58, 58, 58, 38, 19, 0, 0, 0, 0; 0, 0, 14, 29, 44, 44, 44, 44, 44, 44, 29, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 24, 48, 48, 48, 48, 48, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 24, 36, 36, 36, 36, 36, 36, 24, 12, 0, 0, 0, 0, 0, 0];
