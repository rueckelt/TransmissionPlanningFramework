% t_n_i
% time:
generate_model = 3995;
duration_to_solve_model_us = 196;
create_model = 22;
% allocatedChunks
allocatedChunks(:,:,1) = [5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 0, 0, 0, 5; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0];
allocatedChunks(:,:,2) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 18; 0, 0, 0, 0; 0, 0, 17, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
% non_allocated
non_allocated = [25, 0];
% dl_vio
dl_vio = [0, 0];
% st_vio
st_vio = [0, 0];
% vioThroughput
vioThroughput = [0, 0];
% non_allo_vio
non_allo_vio = [1400, 0];
% nChunks
nChunks = [150, 35];
% prefStartTime
prefStartTime = [0, 12];
% deadline
deadline = [30, 13];
% availBW
availBW = [34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34; 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, 67, 67, 67, 67, 67, 33, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 18, 37, 56, 56, 56, 56, 56, 56, 37, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 23, 47, 47, 47, 47, 47, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
