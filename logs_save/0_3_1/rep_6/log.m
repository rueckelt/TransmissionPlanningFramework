% t_n_i
% time:
generate_model = 6725;
duration_to_solve_model_us = 822;
create_model = 38;
% allocatedChunks
allocatedChunks(:,:,1) = [5, 0, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 5, 0; 0, 0, 5, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 5; 0, 0, 0, 0, 0, 0, 0, 5; 0, 0, 0, 0, 0, 0, 0, 5; 0, 0, 0, 0, 0, 0, 0, 5; 0, 0, 0, 0, 0, 0, 0, 5; 0, 0, 0, 0, 5, 0, 0, 0; 0, 0, 0, 0, 5, 0, 0, 0; 0, 0, 0, 0, 5, 0, 0, 0; 0, 0, 0, 0, 5, 0, 0, 0; 0, 0, 0, 0, 5, 0, 0, 0; 0, 0, 0, 0, 5, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0];
allocatedChunks(:,:,2) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 35, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
% non_allocated
non_allocated = [35, 0];
% dl_vio
dl_vio = [0, 0];
% st_vio
st_vio = [0, 0];
% vioThroughput
vioThroughput = [0, 0];
% non_allo_vio
non_allo_vio = [1960, 0];
% nChunks
nChunks = [160, 35];
% prefStartTime
prefStartTime = [0, 12];
% deadline
deadline = [32, 13];
% availBW
availBW = [25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25; 0, 24, 48, 72, 72, 72, 72, 72, 72, 48, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 44, 66, 66, 66, 66, 66, 66, 44, 22, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 46, 46, 46, 46, 46, 23, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 37, 37, 37, 37, 37, 18, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 40, 61, 61, 61, 61, 61, 61, 40, 20, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 21, 42, 63, 63, 63, 63, 63, 63, 42, 21, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 10, 20, 31, 31, 31, 31, 31, 31, 31, 20, 10, 0, 0, 0, 0, 0, 0];
