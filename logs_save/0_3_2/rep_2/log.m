% t_n_i
% time:
generate_model = 12924;
duration_to_solve_model_us = 1683;
create_model = 52;
% allocatedChunks
allocatedChunks(:,:,1) = [5, 0, 0, 0, 0, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 5, 0, 0, 0, 0; 0, 0, 0, 5, 0, 0, 0, 0; 0, 0, 0, 5, 0, 0, 0, 0; 0, 0, 0, 5, 0, 0, 0, 0; 0, 0, 0, 0, 0, 5, 0, 0; 0, 0, 0, 0, 0, 0, 0, 5; 0, 0, 0, 5, 0, 0, 0, 0; 0, 0, 0, 5, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 5, 0; 0, 0, 0, 0, 0, 0, 5, 0; 0, 0, 0, 0, 0, 0, 5, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0];
allocatedChunks(:,:,2) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 9, 0, 0, 0, 0; 0, 0, 0, 26, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
allocatedChunks(:,:,3) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 12, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
allocatedChunks(:,:,4) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 5, 0, 0, 0, 0, 0, 0; 0, 66, 0, 0, 0, 0, 0, 0; 0, 66, 0, 0, 0, 0, 0, 0; 0, 66, 0, 0, 0, 0, 0, 0; 0, 66, 0, 0, 0, 0, 0, 0; 0, 66, 0, 0, 0, 0, 0, 0; 0, 42, 0, 0, 0, 0, 0, 0; 22, 0, 0, 0, 0, 0, 0, 0; 17, 0, 0, 0, 0, 0, 0, 0; 17, 0, 0, 0, 0, 0, 0, 0; 17, 0, 0, 0, 0, 0, 0, 0];
% non_allocated
non_allocated = [25, 0, 0, 0];
% dl_vio
dl_vio = [0, 0, 0, 0];
% st_vio
st_vio = [0, 0, 0, 750];
% vioThroughput
vioThroughput = [0, 0, 0, 0];
% non_allo_vio
non_allo_vio = [1400, 0, 0, 0];
% nChunks
nChunks = [150, 35, 12, 450];
% prefStartTime
prefStartTime = [0, 6, 0, 18];
% deadline
deadline = [30, 7, 100000, 48];
% availBW
availBW = [22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 47, 71, 71, 71, 71, 71, 71, 71, 47, 23, 0, 0, 0; 0, 0, 0, 0, 31, 62, 62, 62, 62, 62, 31, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 15, 31, 47, 47, 47, 47, 47, 47, 47, 31, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 52, 52, 52, 52, 52, 26, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 38, 76, 76, 76, 76, 76, 38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 19, 39, 59, 59, 59, 59, 59, 59, 39, 19, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 15, 30, 45, 45, 45, 45, 45, 45, 45, 30, 15, 0, 0, 0, 0, 0, 0, 0];
